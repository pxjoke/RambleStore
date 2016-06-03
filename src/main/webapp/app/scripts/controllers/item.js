'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:ItemCtrl
 * @description
 * # ItemCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('ItemCtrl', function (Items, $routeParams, $location, $rootScope, $cookies) {
    var that = this;
    that.itemID = $routeParams.itemID;

    isAuth();
    function isAuth() {
      if($cookies.get("RmUser")){
        $rootScope.rootUser = $cookies.get("RmUser");
      }
      if(!$cookies.get("RmUser")){
        $location.url("/");
      }
    }
    
    that.delete = function () {
      Items.delete(that.itemID,
        function (data) {
          console.log("Item deleted");
          $location.url("/");
        },
        function (data) {
          console.log("Error while deleting item");
          console.dir(data);
        });
    };

    that.addToCart = function () {
      Items.addToCart(
        that.itemID,
        function (data) {
          console.log("Added to cart");
          $location.url("/cart");
        },
        function (data) {
          console.log("Error " + data);
          console.dir(data);
        });
    };

    Items.getItem(that.itemID, function (data) {
      that.item = data;
    }, function (data) {
      console.log("Error " + data);
      console.dir(data);
    });


  });
