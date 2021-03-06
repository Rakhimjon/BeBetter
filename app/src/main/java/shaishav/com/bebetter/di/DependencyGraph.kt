/*
 * Copyright (c) 2018 Shaishav Gandhi
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions
 *  and limitations under the License.
 */

package shaishav.com.bebetter.di

import com.uber.autodispose.LifecycleScopeProvider
import shaishav.com.bebetter.contracts.PickGoalContract
import shaishav.com.bebetter.contracts.SummaryContract
import shaishav.com.bebetter.di.components.PickGoalComponent
import shaishav.com.bebetter.di.components.ServiceComponent
import shaishav.com.bebetter.di.components.HomeComponent
import shaishav.com.bebetter.di.components.SummaryComponent
import shaishav.com.bebetter.di.modules.HomeModule

/**
 * Created by shaishav.gandhi on 12/17/17.
 */
interface DependencyGraph {

  fun addHomeComponent(module: HomeModule): HomeComponent
  fun removeHomeComponent()

  fun addPickGoalComponent(view: PickGoalContract, lifecycleScopeProvider: LifecycleScopeProvider<*>): PickGoalComponent
  fun removePickGoalComponent()

  fun addSummaryComponent(view: SummaryContract, lifecycleScopeProvider: LifecycleScopeProvider<*>): SummaryComponent
  fun removeSummaryComponent()

  fun addServiceComponent(): ServiceComponent
  fun removeServiceComponent()
}