
package com.i27academy.builds;

class Calculator {
    def jenkins 
    Calculator(jenkins) {
        this.jenkins = jenkins
    }

    def add(firstNumber, secondNumber) {
        return firstNumber + secondNumber
    }
}

 //
import com.i27academy.builds.Calculator

def call(Map pipelineParams) {
    Calculator calculator = new Calculator(this)
    pipeline {
        agent {
            label 'java-slave'
        }
        // environment {
        //     APPLICATION_NAME = "${pipelineParams.appName}"
        // }
        stages {
            stage ('this is SHARED_LIB_EXAMPLE') {
                steps {
                    script {
                        echo "calling calculator method from src folder"
                        echo " * * * * *  PRINTING SUM OF VALUES * * * * * "
                        println calculator.add(2,3)
                    }
                }
            }
            
        }

    }
}
    

//
@Library("com.i27academy.slb@main") _
firstPipeline(
    appName:  'cart-ms'
)