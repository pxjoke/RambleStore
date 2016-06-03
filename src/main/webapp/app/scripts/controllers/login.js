'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('LoginCtrl', function (Users, $location, $cookies, $rootScope) {
    var that = this;
    that.user = {};

    that.login = function(){
      Users.login(that.user,
      function (data) {
        if(data){
          $cookies.putObject('RmUser', data);
          console.dir($cookies.getObject('RmUser'));
          $rootScope.rootUser = data;
          $location.url("/account");
          return;
        }
        alert("Wrong email/password!");
      },
      function (data) {
        console.log("Error while login");
      });
    }
  });
