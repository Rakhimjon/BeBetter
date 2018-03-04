package shaishav.com.bebetter.utils

import android.app.Application
import android.content.Intent
import android.os.Build
import com.facebook.stetho.Stetho
import shaishav.com.bebetter.BuildConfig
import shaishav.com.bebetter.contracts.PickGoalContract
import shaishav.com.bebetter.di.DependencyGraph
import shaishav.com.bebetter.di.components.*
import shaishav.com.bebetter.di.modules.AppModule
import shaishav.com.bebetter.di.modules.PickGoalModule
import shaishav.com.bebetter.di.modules.SummaryModule
import shaishav.com.bebetter.service.UsageService
import timber.log.Timber

/**
 * Created by shaishav.gandhi on 2/23/18.
 */
class BBApplication : Application(), DependencyGraph {

  lateinit var appComponent: AppComponent
  private var summaryComponent: SummaryComponent? = null
  private var serviceComponent: ServiceComponent? = null
  private var pickGoalComponent: PickGoalComponent? = null

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

    Stetho.initializeWithDefaults(this)

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      startForegroundService(Intent(applicationContext, UsageService::class.java))
    } else {
      startService(Intent(applicationContext, UsageService::class.java))
    }

  }

  override fun addSummaryComponent(module: SummaryModule): SummaryComponent {
    if (summaryComponent == null) {
      summaryComponent = appComponent.addSummaryComponent(module)
    }
    return summaryComponent as SummaryComponent
  }

  override fun removeSummaryComponent() {
    summaryComponent = null
  }

  override fun addServiceComponent(): ServiceComponent {
    if (serviceComponent == null) {
      serviceComponent = appComponent.addServiceComponent()
    }
    return serviceComponent as ServiceComponent
  }

  override fun addPickGoalComponent(view: PickGoalContract): PickGoalComponent {
    if (pickGoalComponent == null) {
      pickGoalComponent = appComponent.addPickGoalComponent(PickGoalModule(view))
    }
    return pickGoalComponent as PickGoalComponent
  }

  override fun removePickGoalComponent() {
    pickGoalComponent = null
  }

  override fun removeServiceComponent() {
    serviceComponent = null
  }
}