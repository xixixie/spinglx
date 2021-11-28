#!groovy


pipeline {
  agent any

  stages {
    stage('拉取代码') {
      steps {
          script {
              checkout([$class: 'GitSCM',
                        branches: [[name: '*/devlop-gitee']],
                        extensions: [],
                        userRemoteConfigs: [[credentialsId: 'd4a9c355-441e-4e67-85ed-5d32da0d4f4c',
                                             url: 'https://gitee.com/wcw19961023/test.git']]])
          }
      }
    }

    stage('构建打包') {
          steps {
              script {
                  echo "构建打包"
              }
          }
    }
    stage('发布') {
          steps {
              script {
                  echo "发布"
              }
          }
    }
  }

}
