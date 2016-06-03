'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:CreateItemCtrl
 * @description
 * # CreateItemCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('CreateItemCtrl', function (Items, $location, $cookies, $rootScope) {
    var that = this;
    that.item = {};

    isAuth();
    function isAuth() {
      if($cookies.getObject("RmUser")){
        $rootScope.rootUser = $cookies.getObject("RmUser");
        console.dir($cookies.getObject("RmUser"));
      }
      if(!$cookies.getObject("RmUser") || ($cookies.getObject("RmUser")).role !== 'admin'){
        $location.url("/");
      }
    }

    that.createItem = function () {
      Items.create(that.item, function (data) {
        console.log("New item created");
        console.dir(data);
        $location.url("/");
      },function (data) {
        console.log("Error while creating item.");
        console.dir(data);
      })
    };

  });
