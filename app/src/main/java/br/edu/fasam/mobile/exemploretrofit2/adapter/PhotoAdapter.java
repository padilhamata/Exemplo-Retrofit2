package br.edu.fasam.mobile.exemploretrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fasam.mobile.exemploretrofit2.R;
import br.edu.fasam.mobile.exemploretrofit2.representacao.Photos;


public class PhotoAdapter extends BaseAdapter {

    Context context;
    List<Photos> colecao;
    LayoutInflater inflter;

    public PhotoAdapter(final Context applicationContext,
                         final List<Photos> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }

    @Override
    public int getCount() {
        return this.colecao!=null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_photo,
                            parent, false);
        }

        // pega o objeto corrente da lista
        Photos photos= (Photos)getItem(position);

        //Declarar campos para preencher o layout item
        TextView AlbumId, idPhoto, title;

        //Pegando referencia da campo no layout item
        AlbumId = view.findViewById(R.id.txtAlbumId);
        title = view.findViewById(R.id.txtTitle);

        //Prencher item do layout como o objeto Photos
        AlbumId.setText(String.valueOf(photos.getAlbumId()));
        title.setText(photos.getTitle());

        return view;
    }
}
