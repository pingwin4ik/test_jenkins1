#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*



job("project_test/test-compile") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "ls -al /var/lib/jenkins/workspace/project_test/cloneFromGit/"
    }
//    steps {
//
//        dsl {
//            external "test/jobs/createBuldTestJobs.groovy"
//        }
//    }
}
job("project_test/test") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "pypline /var/lib/jenkins/workspace/project_test/cloneFromGit/mysite/HelloWorldApp/views.py || exit 0"
    }

}
job("project_test/build") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "echo 'buils code'"
    }

}
job("project_test/deploy") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "echo 'deploy code'"
    }

}

