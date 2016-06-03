'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:UserCtrl
 * @description
 * # UserCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('UserCtrl', function (account, $cookies, $rootScope, $location) {
    var that = this;
    isAuth();
    function isAuth() {
      if($cookies.getObject("RmUser")){
        $rootScope.rootUser = $cookies.getObject("RmUser");
      }
      if(!$cookies.getObject("RmUser")){
        $location.url("/");
      }
    }

    account.getOrders(
      function (data) {
        that.orders = data;
      },
      function (data) {
        console.log("Error " + data);
        console.dir(data);
      });

    account.getUser(
      function (data) {
        that.user = data;
      },
      function (data) {
        console.log("Error " + data);
        console.dir(data);
      });
  });
