'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:CartCtrl
 * @description
 * # CartCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('CartCtrl', function (account) {
    var that = this;
    
    account.getCart(
      function (data) {
        that.cart = data;
      },
      function (data) {
        console.log("Error while getting cart");
        console.dir(data);
      });
    
  });
