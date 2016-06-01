'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:CatalogCtrl
 * @description
 * # CatalogCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('CatalogCtrl', function (Items) {
    var that = this;
    that.items = null;

    Items.search({},
      function (data) {
        that.items = data;
        console.log(data);
      },
    function (data) {
      console.log("Error, while loading data");
    })
  });
