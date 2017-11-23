function steamrollArray(arr) {
  // I'm a steamroller, baby
  newArray = [];
  arr2 = arr;
  //  return Array.isArray(arr[0]);

  return add(arr2);

  function add(arr2) {

    for (i = 0; i < arr2.length; i++) {
      if (Array.isArray(arr2[i]) === true) {
        add(arr2[i]);
      } else {
        newArray.push(arr2[i]);
      }
    }

    return newArray;
  } //add(arr2);
}

steamrollArray([[['a']], [['b']]]);