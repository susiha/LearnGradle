package com.susiha
import org.gradle.api.Plugin
import org.gradle.api.Project

//自定义对象插件
class AppInfoPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        showTask(project)
    }


    private void showTask(Project project){
        project.task('showCustomPlugin'){
            doLast{
                println "this is myFirstPlugin in $project"
            }
        }

    }

}
