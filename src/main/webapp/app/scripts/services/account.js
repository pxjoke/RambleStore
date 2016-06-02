'use strict';

/**
 * @ngdoc service
 * @name rambleApp.account
 * @description
 * # account
 * Factory in the rambleApp.
 */
angular.module('rambleApp')
  .factory('account', function (Network) {
    return {
      getCartPositions: function (onSuccess, onError) {
        return Network.sendGet("/account/cart/positions", {}, onSuccess, onError);
      },
      getCart: function (onSuccess, onError) {
        return Network.sendGet("/account/cart", {}, onSuccess, onError);
      },
      closeCart: function (onSuccess, onError) {
        return Network.sendPut("/account/cart", {}, onSuccess, onError);
      }
    };
  });
