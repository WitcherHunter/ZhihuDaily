package com.example.zhou.daggertest

import android.content.Context
import com.example.zhou.daggertest.data.qualifier.ApplicationQualifier
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by zhou on 2017/3/16.
 */

@Module
class AppModule(private val app : App){

    @Provides @Singleton
    fun provideApplication() : App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext() : Context = app

    @Provides @Singleton
    fun providePicasso(@ApplicationQualifier context: Context) : Picasso = Picasso.Builder(context).build()
}