#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*

def folderName = 'project_test'


folder(folderName) {
    displayName('Project Test')
    description('Folder for project Test')
}

def pathWorkspace = "/var/lib/jenkins/workspace/${folderName}"


job("${folderName}/cloneFromGit") {
    logRotator(-1, 10)
    scm {
        github('kv020devops/jenkins', 'master')
    }
    triggers {
       // githubPush()
        scm('H/2 * * * *')
    }
//    steps {
//
//        dsl {
//            external "test/jobs/createBuldTestJobs.groovy"
//        }
//    }
}
job("${folderName}/createBuldTestJobs") {
    logRotator(-1, 10)
    scm {
        github('kv020devops/test_jenkins1', 'master')
    }
    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps {

        dsl {
            external "${folderName}/jobs/createBuldTestJobs.groovy"
        }
    }
}
pipelineJob("${folderName}-pipeline") {
    definition {
        cps {
            script(readFileFromWorkspace("${pathWorkspace}/pipeline/first.groovy"))
            sandbox()
        }
    }
}
