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

package shaishav.com.bebetter.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import shaishav.com.bebetter.service.WorkflowService
import shaishav.com.bebetter.utils.BBApplication
import shaishav.com.bebetter.workflow.UsageWorkflow
import java.util.*
import javax.inject.Inject

/**
 * Created by shaishav.gandhi on 3/11/18.
 */
class ShutdownReceiver: BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent) {
    val serviceIntent = Intent(context, WorkflowService::class.java)
    serviceIntent.action = WorkflowService.ACTION_OFF
    context.startService(serviceIntent)
  }
}