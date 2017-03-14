package com.szb.nh.network;

        import com.szb.nh.model.retrofit.PlayerDTO;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface NetworkService {
    @GET("/players/{player}")
    Call<PlayerDTO> login(@Path("player") String player);
}
