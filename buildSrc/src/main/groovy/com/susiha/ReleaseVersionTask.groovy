package com.susiha

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class ReleaseVersionTask extends DefaultTask {

    //通过注解声明task的输入和输出
    @Input Boolean release
    @OutputFile File destFile
    //在构造器中设置group和description
    ReleaseVersionTask(){
        group = 'versioning'
        description = 'Makes project a release version'
    }
    //使用注解声明将被执行的方法
    @TaskAction
    void start(){
        project.version.release = true
        ant.propertyfile(file: destFile){
            entry(key:'release',type:'string',operation:'=',value:'true')
        }
    }

}
