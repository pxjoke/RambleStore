'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('MainCtrl', function (Items, $cookies) {
    $cookies.put('userID', 1);
    var that = this;
    that.items = null;

    Items.search({},
      function (data) {
        that.items = data;
        console.log(data);
      },
      function (data) {
        console.log("Error, while loading data");
      });
  });
