function load_more_post() {
	var post_num = $('.post').toArray().length
	console.log(post_num)
	
	$.post("/WebClass/loadpost.do", 
		{
		'search': 'json here?', 
        'isTimeline': true,
        'userToSearch': 'test@naver.com'
		},
		function(data) {
		console.log(data)
	    $('#posts').loadTemplate($('#post-template'),
		    {
		    profile_src: '/image/profiles/' + data.user.id + ".jpg",
		    nickname: data.user.nickname,
			title: data.post.title,
			url: data.post.url,
			surl: data.post.surl,
			url_thumbnail: data.post.urlThumbnail,
			url_text: data.post.urlText,
			user_text: data.post.userText,
			tags: data.post.tags
			}, 
			{ append: true })
		})
}