package com.susiha

import org.gradle.api.Project
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

class NotificationTestListener implements TestListener {
    final Project project
     NotificationTestListener(Project project){
         this.project = project
     }

    @Override
    void beforeSuite(TestDescriptor testDescriptor) {
    }
    @Override
    void afterSuite(TestDescriptor suite, TestResult result) {

        if(!suite.parent&&result.getTestCount()>0){
            long elapsedTestTime = result.getEndTime() -result.getStartTime()

            project.logger.quiet """ Elapsed time for execution of ${result.getTestCount()}
                         test(s):$elapsedTestTime ms"""
        }

    }

    @Override
    void beforeTest(TestDescriptor testDescriptor) {

    }

    @Override
    void afterTest(TestDescriptor testDescriptor, TestResult testResult) {

    }
}
