 function createMap() {
    const map = new google.maps.Map(document.getElementById('map'),
    {
        center: {lat: 40.102, lng: -88.227},
        zoom: 11
    }); 
    var ECEBMarker = new google.maps.Marker(
        {
            position: {lat: 40.1149, lng: -88.2280},
            animation: google.maps.Animation.DROP,
            map: map
        });
    var ECEBContent = 
        "<h1>Electrical and Computer Engineering Building (ECEB)</h1>" +
        "<p>As the largest engineering department on campus, ECE also " +
        "boasts one of the most technologically advanced buildings on " +
        "U of I's Campus as well. In addition to housing the largest " +
        "lecture hall on engineering campus ECEB also contains 25 " +
        "instructional labratories. The upper levels of ECEB are "+
        "dedicated to advanced power applications research which, along " +
        "with the solar panels that line the roof make ECEB one of the " +
        "largest net-zero energy buildings in the world.</p>" +
        "<p>Many ECE majors, including myself, find ECEB to be a second " +
        "home, especially because you often spend more time there than " +
        "at home.</p>"
    var ECEBInfo = new google.maps.InfoWindow({
          content: ECEBContent
    });
    ECEBMarker.addListener('click', function() {
      ECEBInfo.open(map, ECEBMarker);
    }); 

    var stockPavilionMarker = new google.maps.Marker(
        {
            position: {lat: 40.1010, lng: -88.2272},
            animation: google.maps.Animation.DROP,
            map: map
        });
    var stockPavilionContent = 
        "<h1>Stock Pavilion</h1>" +
        "<p>While the Stock Pavilion was originally constructed for " +
        "studying livestock, it large open space has made it one of " +
        "the most versatile in door spaces on campus. One of its many " +
        "uses is being the indoor practice space for the Illini " +
        "Ridgebacks Quidditch Team. Before becoming an official club " +
        "sport, the Ridgebacks would also use open areas around the " +
        "stock pavillion for outdoor practices.</p>"
    var stockPavilionInfo = new google.maps.InfoWindow({
          content: stockPavilionContent
    });
    stockPavilionMarker.addListener('click', function() {
      stockPavilionInfo.open(map, stockPavilionMarker);
    });

    var CUSCMarker = new google.maps.Marker(
        {
            position: {lat: 40.24334, lng: -88.082123},
            animation: google.maps.Animation.DROP,
            map: map
        });
    var CUSCContent = 
        "<h1>Champaign-Urbana Skydiving Club (CUSC)</h1>" +
        "<p>What started as a small group of skydivers that wanted " +
        "to share their love of the sport with others, CUSC is the " +
        "sponsoring drop zone for the Falling Illini Skydiving Club. " +
        "In addition to making skydiving more accessible to all " +
        "UIUC students, CUSC also provides USPA-A License training, " +
        "which allows a person to perform solo jumps at any USPA " +
        "drop zone in the USA.</p>"
    var CUSCInfo = new google.maps.InfoWindow({
          content: CUSCContent
    });
    CUSCMarker.addListener('click', function() {
      CUSCInfo.open(map, CUSCMarker);
    });
    
}