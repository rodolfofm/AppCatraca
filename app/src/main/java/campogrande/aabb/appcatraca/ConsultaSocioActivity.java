package campogrande.aabb.appcatraca;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ConsultaSocioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_socio);

        ArrayList<Socio> socios = new ArrayList<Socio>();

        for(int i = 0; i < 5; i++){

            Socio socio = new Socio();
            socio.setMatricula((i + 1));
            socio.setNome("Socio "+(i + 1));

            socios.add(socio);
        }

        ListView lv = (ListView) findViewById(R.id.lvSocios);
        lv.setAdapter(new ConsultaSocioAdapter(this, socios));
    }
}
