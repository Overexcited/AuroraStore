/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 *
 * Restarts Aurora through its normal launcher Activity/task.
 */

package com.aurora.store.util

import android.content.Context
import android.content.Intent
import android.os.Process

object AppRestart {
    fun restart(context: Context) {
        val launchIntent = context.packageManager
            .getLaunchIntentForPackage(context.packageName)
            ?: return

        val restartIntent = Intent.makeRestartActivityTask(launchIntent.component)
        context.startActivity(restartIntent)
        Process.killProcess(Process.myPid())
    }
}
