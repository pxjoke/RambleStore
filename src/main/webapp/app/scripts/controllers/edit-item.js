'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:EditItemCtrl
 * @description
 * # EditItemCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('EditItemCtrl', function (Items, $routeParams, $cookies, $rootScope) {

    var that = this;
    that.item = {};
    that.itemID = $routeParams.itemID;

    isAuth();
    function isAuth() {
      if($cookies.getObject("RmUser")){
        $rootScope.rootUser = $cookies.getObject("RmUser");
      }
      if(!$cookies.getObject("RmUser") || $cookies.getObject("RmUser").role !== 'admin'){
        $location.url("/");
      }
    }

    Items.getItem(that.itemID,
      function (data) {
        that.item = data;
      },
      function (data) {
        console.log("Error while loading item data");
      });

    that.editItem = function () {
      Items.edit(that.itemID, that.item, function (data) {
        console.log("Item edited");
        console.dir(data);
      }, function (data) {
        console.log("Error while editing item.");
        console.dir(data);
      })
    };
  });
