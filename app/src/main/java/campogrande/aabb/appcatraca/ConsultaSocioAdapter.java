package campogrande.aabb.appcatraca;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rodolfo on 13/03/2017.
 */

public class ConsultaSocioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Socio> lista;

    public ConsultaSocioAdapter(Context context, ArrayList<Socio> lista){
        this.context = context;
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder {
     //   ImageView imageView;
        TextView txtMatricula;
        TextView txtNome;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_consulta_socios_partial, null);
            holder = new ViewHolder();
            holder.txtMatricula = (TextView) convertView.findViewById(R.id.tv_matricula);
            holder.txtNome = (TextView) convertView.findViewById(R.id.tv_nome);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        Socio socio = lista.get(position);

        holder.txtMatricula.setText(String.valueOf(socio.getMatricula()));
        holder.txtNome.setText(socio.getNome());


        if(socio.isTitular()){
            convertView.setBackgroundColor(Color.YELLOW);
        }
        return convertView;
    }
}
