#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*

def folderName = 'project_tes'
def pathWorkspace = '/var/lib/jenkins/workspace/${folderName}'


folder(folderName) {
    displayName('Project Test')
    description('Folder for project Test')
}

job("${folderName}/test") {
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
//            external "test/jobs/first.groovy"
//        }
//    }
}

listView("${folderName}") {
        description("All unstable jobs for ${folderName}")
        filterBuildQueue()
        filterExecutors()
        jobs {
            name("${folderName}/test")
            regex(/project_tes-.+/)
        }
}
