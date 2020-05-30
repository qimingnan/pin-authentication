package io.matthewnelson.pin_authentication.di.application

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.matthewnelson.pin_authentication.di.PAInjection
import io.matthewnelson.pin_authentication.di.activity.PAActivityComponent
import io.matthewnelson.pin_authentication.di.application.module.PAApplicationModule
import io.matthewnelson.pin_authentication.di.application.module.PACoroutineDispatchersModule
import io.matthewnelson.pin_authentication.di.application.module.PAPrefsModule
import io.matthewnelson.pin_authentication.util.annotations.NotForPublicConsumption

/**
 * @suppress
 * */
@NotForPublicConsumption
@PAApplicationScope
@Component(
    modules = [
        PAApplicationModule::class,
        PACoroutineDispatchersModule::class,
        PAPrefsModule::class
    ])
interface PAApplicationComponent {

    fun getPAActivityComponentBuilder(): PAActivityComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): PAApplicationComponent
    }

    @OptIn(NotForPublicConsumption::class)
    fun inject(paInjection: PAInjection)
}