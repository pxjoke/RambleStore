'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:UsersCtrl
 * @description
 * # UsersCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('UsersCtrl', function (Users) {
    var that = this;
    that.deleteUser = function (userID) {
      Users.deleteUser(userID, function (data) {
        console.log("User " + userID + "deleted!");
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
