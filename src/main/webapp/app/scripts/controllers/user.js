'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:UserCtrl
 * @description
 * # UserCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('UserCtrl', function (account) {
    var that = this;

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
