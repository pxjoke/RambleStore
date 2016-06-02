'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:CartCtrl
 * @description
 * # CartCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('CartCtrl', function (account, $location) {
    var that = this;

    account.getCartPositions(
      function (data) {
        that.cartPositions = data;
      },
      function (data) {
        console.log("Error while getting cart positions");
        console.dir(data);
      });

    account.getCart(
      function (data) {
        that.cart = data;
      },
      function (data) {
        console.log("Error while getting cart");
        console.dir(data);
      });

    that.closeCart = function () {
      account.closeCart(
        function (data) {
          console.log("Cart is closed");
          $location.url("account");
        },
        function (data) {
          console.log("Error while closing cart");
          console.dir(data);
        });
    }
  });
