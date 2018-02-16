package shaishav.com.bebetter.contracts

import shaishav.com.bebetter.data.models.Goal
import shaishav.com.bebetter.data.models.Usage

/**
 * Created by shaishav.gandhi on 12/17/17.
 */
interface SummaryContract {
    
    fun setAverageDaiyUsage(usage: Long)
    fun setDailyUsage(usage: Long)
    fun setCurrentSession(usage: Long)
    fun setTotalUsage(usage: Long)
    fun setGoals(goals: List<Goal>)
    fun setUsages(usages: List<Usage>)

}