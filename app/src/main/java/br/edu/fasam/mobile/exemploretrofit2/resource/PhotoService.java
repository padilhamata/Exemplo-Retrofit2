package br.edu.fasam.mobile.exemploretrofit2.resource;

import java.util.List;

import br.edu.fasam.mobile.exemploretrofit2.representacao.Photos;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PhotoService {

    //Envia um posts para o servidor
    @POST("photos")
    Call<Photos> post(@Body Photos photos);

    //Recuperada um posts baseado em um ID
    @GET("photos/{id}")
    Call<Photos> get(@Path("id") Integer id);

    //Tràs a lista de posts;
    @GET("photos")
    Call<List<Photos>> get();

    //Atualizada o objeto posts inteiramente
    @PUT("photos/{id}")
    Call<Photos> put(@Path("id") Integer id, @Body Photos photos);

    //Atualiza parcialmente um post
    @PATCH("photos/{id}")
    Call<Photos> patch(@Path("id") Integer id, @Body Photos photos);

    //Apaga um posts baseado em um ID
    @DELETE("photos/{id}")
    Call<Void> delete(@Path("id") Integer id);

}
