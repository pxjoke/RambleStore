'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('MainCtrl', function (Items, $cookies, $rootScope) {
    $cookies.put('userID', 1);
    var that = this;
    that.items = null;
    isAuth();
    function isAuth() {
      if ($cookies.getObject("RmUser")) {
        $rootScope.rootUser = $cookies.getObject("RmUser");
        console.dir($cookies.getObject("RmUser"));
      }
    }

    Items.search({},
      function (data) {
        that.items = data;
        console.log(data);
      },
      function (data) {
        console.log("Error, while loading data");
      });
  });
