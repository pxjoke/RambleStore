'use strict';

/**
 * @ngdoc service
 * @name rambleApp.Network
 * @description
 * # Network
 * Service in the rambleApp.
 */
angular.module('rambleApp')
  .service('Network', function ($http) {

    function getRequest(method, url, parameters, headers) {
      return ((method === "GET" || method === "DELETE") ? $http({
        method: method,
        url: url,
        params: parameters,
        headers: headers
      }) : $http({method: method, url: url, data: parameters}));
    }

    var sendQuery = function (url, method, parameters, headers, onSuccess, onError) {
      getRequest(method, url, parameters, headers).then(
        function (response) {
          if (response.data.status === "ERROR") {
            onError(response.message);
            return;
          }
            onSuccess(response.data.payload);
        },
        function (response) {
          onError(response);
        });
    };

    return {
      sendGet: function (url, parameters, onSuccess, onError) {
        sendQuery(url, "GET", parameters, {}, onSuccess, onError);
      },
      sendPost: function (url, parameters, onSuccess, onError) {
        sendQuery(url, "POST", parameters, {}, onSuccess, onError);
      },
      sendDelete: function (url, parameters, onSuccess, onError) {
        sendQuery(url, "DELETE", parameters, {}, onSuccess, onError);
      }

    };
  });
