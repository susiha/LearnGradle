package com.susiha

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.execution.TaskExecutionGraphListener
class ReleaseVersionListener implements TaskExecutionGraphListener {
    final static String releaseTaskPath = ':release'
    @Override
    void graphPopulated(TaskExecutionGraph taskExecutionGraph) {
        // 确定release task 是否包含在执行图中

        List<Task> allTasks1 = taskExecutionGraph.allTasks
        allTasks1.forEach{
            System.out.println(it)
        }

        if(taskExecutionGraph.hasTask(releaseTaskPath)){
            List<Task> allTasks = taskExecutionGraph.allTasks
            Task releaseTask = allTasks.find{it.path == releaseTaskPath}
            System.out.println("Hello")

            allTasks.forEach{
                System.out.println(it)
            }
            //每个Task都知道自己所属的project
            Project project = releaseTask.project
            if(!project.version.release){
                project.version.release = true
                project.ant.propertyfile(file: project.versionFile){
                    entry(key:'release',type:'string',operation:'=',value:'true')
                }
            }
        }


    }
}
