package artista.hackathon;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectorProcessor implements Detector.Processor<TextBlock> {

    private GraphicOverlay<MyGraphic> graphicOverlay;
    private ArrayList<String> list;
    private Context context;

    DetectorProcessor(GraphicOverlay<MyGraphic> ocrGraphicOverlay, Context context) {
        graphicOverlay = ocrGraphicOverlay;
        this.context = context;
    }

    @Override
    public void release() {
        graphicOverlay.clear();
    }

    @Override
    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        graphicOverlay.clear();
        list = new ArrayList<>();
        SparseArray<TextBlock> items = detections.getDetectedItems();
        for (int i = 0; i < items.size(); ++i) {
            TextBlock item = items.valueAt(i);
            if (item != null && item.getValue() != null) {
                Log.d("Processor", "Text detected! " + item.getValue());
                boolean flag = false;
                for (String key : MainActivity.priceList.keySet()){
                    if (key.toLowerCase().contains(item.getValue().toLowerCase())){
                        list.add(item.getValue()+" (\u20B9"+MainActivity.priceList.get(key)+")");
                        flag = true;
                    }
                }
                if (!flag) list.add(item.getValue()+" (X)");
                MyGraphic graphic = new MyGraphic(graphicOverlay, item);
                graphicOverlay.add(graphic);
            }
        }
        MainActivity.updateList(list);
    }
}
