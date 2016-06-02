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
      },
      create: function (item, onSucess, onError){
        return Network.sendPost("/items/", item, onSucess, onError);
      },
      edit: function (itemID, item, onSucess, onError){
        return Network.sendPut("/items/" + itemID, item, onSucess, onError);
      },
      delete: function (itemID, onSucess, onError){
        return Network.sendDelete("/items/" + itemID, {}, onSucess, onError);
      },
      addToCart: function (itemID, onSucess, onError){
        return Network.sendPost("/items/" + itemID + "/addToCart", {}, onSucess, onError);
      }      
    };
  });
