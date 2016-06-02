'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:CreateItemCtrl
 * @description
 * # CreateItemCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('CreateItemCtrl', function (Items, $location) {
    var that = this;
    that.item = {};

    that.createItem = function () {
      Items.create(that.item, function (data) {
        console.log("New item created");
        console.dir(data);
        $location.url("/");
      },function (data) {
        console.log("Error while creating item.");
        console.dir(data);
      })
    };

  });
