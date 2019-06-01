angular.module('polytask', [])
    .controller('MainController', function($scope, $http) {

        $scope.taskname ="";
        $scope.newtask = {};
        $scope.newtask.content="";

        /******* Get all tasks *******/
        var gettasks = function(){
            $http.get('/getTasks').then(function (res) {
                $scope.list_task=res.data;
                console.log($scope.list_task);
            }, function(res){
                console.log("ERROR :", res)
            });
        };

        gettasks();

        /******* Add a task *******/
        $scope.createTodo = function() {
            if($scope.taskname!==null && $scope.taskname!=="" && $scope.taskname!=="undefined"){
                $http.post('/addTask', $scope.taskname).then(function(data) {
                    $scope.taskname = null; // clear the form so our user is ready to enter another
                    gettasks();
                    console.log(data);
                }, function(data) {
                    console.log('Error: ' + data);
                });
            }
            else {
                $scope.taskname = null;
                alert("Remplir le champs vide !");
            }
        };

        /******* delete a task *******/
        $scope.deleteTodo = function(idtask) {
            $http.delete(`/deleteTask/${idtask}`)
                .then(function(data) {
                    gettasks();
                    console.log("delete task Success :" + data);
                }, function(data) {
                    console.log('Error: ' + data);
                });
        };

        /******* update a task *******/

        $scope.updateToDo = function(idtask) {
            // $scope.updateData.idtask = id;
            // $scope.updateData.username = $cookies.username;
            console.log($scope.newtask.content);
            let newContent = $scope.newtask.content;
            console.log(newContent);
            if(newContent!==null && newContent!=="" && newContent!=="undefined" ) {
                $http.put(`/updateTask/${idtask}/${newContent}`).then(function (data) {
                    $scope.newtask.content=null;
                    gettasks();
                    console.log("update task Success :" + data);
                }, function (data) {
                    console.log('Error: ' + data);
                });
            }
            else {
                $scope.newtask.content = null;
                alert("Remplir le champs vide !");
            }
        };


    });