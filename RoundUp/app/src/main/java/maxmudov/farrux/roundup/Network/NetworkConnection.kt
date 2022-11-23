package maxmudov.farrux.roundup.Network

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerInterceptor
import maxmudov.farrux.roundup.utils.Constants
import maxmudov.frarux.roundup.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConnection {

    companion object {

        private fun getRetrofit(context: Context): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            if (com.chuckerteam.chucker.BuildConfig.DEBUG) {
                retrofit.client(getOkhttp(context = context))
            } else {
                retrofit.client(getOkhttpRelease())
            }


            return retrofit.build()
        }

        fun getApi(context: Context): MainApi {
            return getRetrofit(context).create(MainApi::class.java)
        }

        private fun getOkhttp(context: Context): OkHttpClient {

            val client = OkHttpClient().newBuilder()
                .addInterceptor(headerInterceptor())
                .addInterceptor(loggingInterceptor())
                .addInterceptor(chuckInterceptor(context))
                .build()
            return client
        }

        private fun getOkhttpRelease(): OkHttpClient {

            val client = OkHttpClient().newBuilder()
                .addInterceptor(headerInterceptor())
                .addInterceptor(loggingInterceptor())
                .build()

            return client
        }

        private fun headerInterceptor(): Interceptor {

            val interceptor = Interceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                requestBuilder.addHeader("Authorization", "Client-ID mT8hj53DywChJkbscZAN5aHio9v2M9impW_i-VIc7vs")
                return@Interceptor chain.proceed(requestBuilder.build())
            }

            return interceptor
        }

        private fun loggingInterceptor(): Interceptor {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor { message ->


                }
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            return httpLoggingInterceptor
        }

        private fun chuckInterceptor(context: Context): Interceptor {
            return ChuckerInterceptor.Builder(context)
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(true)
                .build()
        }

    }
}