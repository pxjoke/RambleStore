'use strict';

/**
 * @ngdoc service
 * @name rambleApp.users
 * @description
 * # users
 * Service in the rambleApp.
 */
angular.module('rambleApp')
  .factory('Users', function (Network) {
    return {
      search: function (onSuccess, onError) {
        return Network.sendGet("/users", {}, onSuccess, onError);
      },
      deleteUser: function (userID, onSucess, onError){
        return Network.sendDelete("/users/" + userID, {}, onSucess, onError);
      }
    };
  });
