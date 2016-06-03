'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:RegisterCtrl
 * @description
 * # RegisterCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('RegisterCtrl', function (Users, $location) {
    var that = this;
    that.user = {};

    that.register = function() {
      Users.create(that.user,
        function (data) {
          $location.url("/login");
        },
        function (data) {
          console.log("Error while login");
        });
    }

  });
