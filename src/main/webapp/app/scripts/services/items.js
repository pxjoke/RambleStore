'use strict';

/**
 * @ngdoc service
 * @name rambleApp.Items
 * @description
 * # Items
 * Factory in the rambleApp.
 */
angular.module('rambleApp')
  .factory('Items', function (Network) {
    return {
      search: function (params, onSuccess, onError) {
        return Network.sendGet("/items", params, onSuccess, onError);
      },
      getItem: function (itemID, onSucess, onError){
        return Network.sendGet("/items/" + itemID, {}, onSucess, onError);
      }
    };
  });
