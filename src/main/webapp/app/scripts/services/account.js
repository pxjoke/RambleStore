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
      getCart: function (onSuccess, onError) {
        return Network.sendGet("/account/cart", {}, onSuccess, onError);
      }
    };
  });
