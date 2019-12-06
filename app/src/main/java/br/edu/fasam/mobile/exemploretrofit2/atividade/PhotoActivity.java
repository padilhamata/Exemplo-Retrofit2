package br.edu.fasam.mobile.exemploretrofit2.atividade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.edu.fasam.mobile.exemploretrofit2.R;
import br.edu.fasam.mobile.exemploretrofit2.adapter.PhotoAdapter;

import br.edu.fasam.mobile.exemploretrofit2.bootstrap.BoostrapApi;
import br.edu.fasam.mobile.exemploretrofit2.representacao.Photos;

import br.edu.fasam.mobile.exemploretrofit2.resource.PhotoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    EditText txtId;
    EditText txtUserId;
    EditText txtTitle;
    EditText txtBody;
    ListView listView;

    //Criar referência para consumir o serviço de PhotoService
    PhotoService photoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
    }

    private void carregarDados(){

        //Fazer injeção de dependência da INTERFACE
        photoService = BoostrapApi.getClient()
                .create(PhotoService.class);

        Call<List<Photos>> get = photoService.get();

        get.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                //Recuperar a lista de photos
                List<Photos> photos= response.body();

                //Pegar referencia da listView
                listView = findViewById(R.id.listViewPhoto);

                //Chamar o Adapter para trabalhar os dados
                PhotoAdapter adapter =
                        new PhotoAdapter(getApplicationContext(),photos);

                //Fazer "bind" com a listView;
                listView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });



    }

    public void adicionar(View view) {
        carregarDados();
    }
}
