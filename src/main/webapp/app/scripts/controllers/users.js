'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:UsersCtrl
 * @description
 * # UsersCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('UsersCtrl', function (Users, $route, $location, $rootScope, $cookies) {
    var that = this;

    isAuth();
    function isAuth() {
      if($cookies.getObject("RmUser")){
        $rootScope.rootUser = $cookies.getObject("RmUser");
      }
      if(!$cookies.getObject("RmUser") || $cookies.getObject("RmUser").role !== 'admin'){
        $location.url("/");
      }
    }
    
    that.deleteUser = function (userID) {
      Users.deleteUser(userID, function (data) {
        console.log("User " + userID + "deleted!");
        $route.reload();
      },
      function (data) {
        
        console.log("Error while deleting user.")
      });
    };

    Users.search(function(data){
      that.users = data;
    }, function (data) {
      console.log("Error while loading users data.");
      console.dir(data);
    });
  });
