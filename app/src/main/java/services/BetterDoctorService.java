package services;

import com.skylar.futurefit.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import models.Doctor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BetterDoctorService{
    public static void findDoctorsByLocationAndSpecialty(String specialty, String location, Callback callback) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BETTER_DOCTOR_BASE_URL).newBuilder();
            urlBuilder.addQueryParameter(Constants.BETTER_DOCTOR_SPECIALTY_QUERY_PARAMETER, specialty);
             urlBuilder.addQueryParameter(Constants.BETTER_DOCTOR_LOCATION_QUERY_PARAMETER, location);
            urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.USER_KEY);
            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(callback);
        }

    public ArrayList<Doctor> processResults(Response response) {
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject betterDoctorJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = betterDoctorJSON.getJSONArray("data");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject doctorJSON = resultsJSON.getJSONObject(i);
                    String name = doctorJSON.getJSONArray("practices").getJSONObject(0).getString("name");
                    String specialty = doctorJSON.getJSONArray("specialties").getJSONObject(0).getString("actor");
//                    String phone = doctorJSON.getJSONArray("phones").getString("number");
//                    double latitude = doctorJSON.getJSONArray("practices").getDouble("lat");
//                    double longitude = doctorJSON.getJSONArray("practices").getDouble("lon");


//                    JSONArray addressJSON = doctorJSON.getJSONObject("practices").getJSONArray("visit_address");
//                    for (int y = 0; y < addressJSON.length(); y++) {
//                        address.add(addressJSON.get(y).toString());
//                    }
//
//                    String bio = doctorJSON.getString("bio");
                    ArrayList<String> phone = new ArrayList<>();
                    JSONArray phoneJSON = doctorJSON.getJSONArray("practices").getJSONObject(0).getJSONArray("phones");
                    for (int y = 0; y < phoneJSON.length(); y++) {
                        phone.add(phoneJSON.getJSONObject(y).getString("number"));
                    }

                    double latitude = doctorJSON.getJSONArray("practices").getJSONObject(0).getDouble("lat");
                    double longitude = doctorJSON.getJSONArray("practices").getJSONObject(0).getDouble("lon");
                    String address = doctorJSON.getJSONArray("practices").getJSONObject(0).getString("visit_address");

                    String bio = doctorJSON.getJSONObject("profile").getString("bio");

                    Doctor doctor = new Doctor(name, specialty, phone, latitude, longitude, address, bio);
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
