var _0x2b4a = [
		'WebSocket',
		'wss://127.0.0.1:8987/Config',
		'onopen',
		'send',
		'config',
		'onmessage',
		'close',
		'onclose',
		'log',
		'Connection\x20is\x20closed...',
		'WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!',
		'wss://127.0.0.1:8987/SignMsg',
		'data',
		'{\x22Error\x22:\x20\x22WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!\x22,\x20\x22Status\x22:500}',
		'wss://127.0.0.1:8987/VerifyMsg',
		'wss://127.0.0.1:8987/VerifyPDF',
		'wss://127.0.0.1:8987/SignOffice',
		'wss://127.0.0.1:8987/VerifyOffice',
		'wss://127.0.0.1:8987/SignFile',
		'wss://127.0.0.1:8987/GetLicenseRequest',
		'request',
		'wss://127.0.0.1:8987/SignXML',
		'wss://127.0.0.1:8987/GetCertInfo',
		'get_cert_info',
		'wss://127.0.0.1:8987/VerifyXML',
		'{\x22Message\x22:\x20\x22WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!\x22,\x20\x22Status\x22:500}',
		'wss://127.0.0.1:8987/SignXMLP12', 'wss://127.0.0.1:8987/SignPDFWP',
		'wss://127.0.0.1:8987/SignIncome', 'wss://127.0.0.1:8987/Auth',
		'wss://127.0.0.1:8987/SignIssued' ];
(function(_0x3479f9, _0x15de1a) {
	var _0x54aa11 = function(_0x143bf3) {
		while (--_0x143bf3) {
			_0x3479f9['push'](_0x3479f9['shift']());
		}
	};
	_0x54aa11(++_0x15de1a);
}(_0x2b4a, 0x155));
var _0x1659 = function(_0x4e3c82, _0x849ca) {
	_0x4e3c82 = _0x4e3c82 - 0x0;
	var _0x59c81f = _0x2b4a[_0x4e3c82];
	return _0x59c81f;
};
function vgca_show_config() {
	if (_0x1659('0x0') in window) {
		var _0x4d4965 = new WebSocket(_0x1659('0x1'));
		_0x4d4965[_0x1659('0x2')] = function() {
			_0x4d4965[_0x1659('0x3')](_0x1659('0x4'));
		};
		_0x4d4965[_0x1659('0x5')] = function(_0x16ffae) {
			_0x4d4965[_0x1659('0x6')]();
		};
		_0x4d4965[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_msg(_0x49043e, _0x56f01c, _0x2d0605) {
	if (_0x1659('0x0') in window) {
		var _0x1b8ea2 = new WebSocket(_0x1659('0xb'));
		_0x1b8ea2[_0x1659('0x2')] = function() {
			_0x1b8ea2[_0x1659('0x3')](_0x56f01c);
		};
		_0x1b8ea2[_0x1659('0x5')] = function(_0xc64465) {
			if (_0x2d0605) {
				_0x2d0605(_0x49043e, _0xc64465[_0x1659('0xc')]);
			}
			_0x1b8ea2[_0x1659('0x6')]();
		};
		_0x1b8ea2[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x2d0605) {
			_0x2d0605(_0x49043e, _0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_verify_msg(_0x3683c9, _0x510a37) {
	if (_0x1659('0x0') in window) {
		var _0x44d950 = new WebSocket(_0x1659('0xe'));
		_0x44d950[_0x1659('0x2')] = function() {
			_0x44d950[_0x1659('0x3')](_0x3683c9);
		};
		_0x44d950[_0x1659('0x5')] = function(_0x44b374) {
			if (_0x510a37) {
				_0x510a37(_0x44b374[_0x1659('0xc')]);
			}
			_0x44d950[_0x1659('0x6')]();
		};
		_0x44d950[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x510a37) {
			_0x510a37(sender, _0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_pdf(_0x4dd753, _0x12bd00) {
	if (_0x1659('0x0') in window) {
		var _0x1a8035 = new WebSocket('wss://127.0.0.1:8987/SignPDF');
		_0x1a8035[_0x1659('0x2')] = function() {
			_0x1a8035['send'](_0x4dd753);
		};
		_0x1a8035[_0x1659('0x5')] = function(_0x33e7d9) {
			if (_0x12bd00) {
				_0x12bd00(_0x33e7d9[_0x1659('0xc')]);
			}
			_0x1a8035[_0x1659('0x6')]();
		};
		_0x1a8035[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x12bd00) {
			_0x12bd00('{\x22Error\x22:\x20\x22WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!\x22,\x20\x22Status\x22:500}');
		}
		console['log'](_0x1659('0xa'));
	}
}
function vgca_verify_pdf(_0xe0a583, _0x50bab4) {
	if (_0x1659('0x0') in window) {
		var _0x57d6de = new WebSocket(_0x1659('0xf'));
		_0x57d6de[_0x1659('0x2')] = function() {
			_0x57d6de[_0x1659('0x3')](_0xe0a583);
		};
		_0x57d6de[_0x1659('0x5')] = function(_0x5a6772) {
			if (_0x50bab4) {
				_0x50bab4(_0x5a6772[_0x1659('0xc')]);
			}
			_0x57d6de['close']();
		};
		_0x57d6de['onclose'] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x50bab4) {
			_0x50bab4(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_office(_0xe4afa2, _0x471df5) {
	if (_0x1659('0x0') in window) {
		var _0x270b90 = new WebSocket(_0x1659('0x10'));
		_0x270b90[_0x1659('0x2')] = function() {
			_0x270b90['send'](_0xe4afa2);
		};
		_0x270b90[_0x1659('0x5')] = function(_0x72868d) {
			if (_0x471df5) {
				_0x471df5(_0x72868d[_0x1659('0xc')]);
			}
			_0x270b90[_0x1659('0x6')]();
		};
		_0x270b90['onclose'] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x471df5) {
			_0x471df5(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_verify_office(_0x16d032, _0x2b8074) {
	if (_0x1659('0x0') in window) {
		var _0x2294ee = new WebSocket(_0x1659('0x11'));
		_0x2294ee[_0x1659('0x2')] = function() {
			_0x2294ee['send'](_0x16d032);
		};
		_0x2294ee[_0x1659('0x5')] = function(_0x5b2986) {
			if (_0x2b8074) {
				_0x2b8074(_0x5b2986[_0x1659('0xc')]);
			}
			_0x2294ee[_0x1659('0x6')]();
		};
		_0x2294ee['onclose'] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x2b8074) {
			_0x2b8074(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_file(_0x2d46c2, _0x235ef3) {
	if ('WebSocket' in window) {
		var _0x2b8433 = new WebSocket(_0x1659('0x12'));
		_0x2b8433[_0x1659('0x2')] = function() {
			_0x2b8433[_0x1659('0x3')](_0x2d46c2);
		};
		_0x2b8433['onmessage'] = function(_0x106a79) {
			if (_0x235ef3) {
				_0x235ef3(_0x106a79[_0x1659('0xc')]);
			}
			_0x2b8433[_0x1659('0x6')]();
		};
		_0x2b8433[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x235ef3) {
			_0x235ef3(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_license_request(_0x4b36a1) {
	if (_0x1659('0x0') in window) {
		var _0x42b7f6 = new WebSocket(_0x1659('0x13'));
		_0x42b7f6[_0x1659('0x2')] = function() {
			_0x42b7f6[_0x1659('0x3')](_0x1659('0x14'));
		};
		_0x42b7f6[_0x1659('0x5')] = function(_0x39405c) {
			if (_0x4b36a1) {
				_0x4b36a1(_0x39405c[_0x1659('0xc')]);
			}
			_0x42b7f6[_0x1659('0x6')]();
		};
		_0x42b7f6[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x4b36a1) {
			_0x4b36a1('{\x22Error\x22:\x20\x22WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!\x22,\x20\x22Status\x22:500}');
		}
		console['log'](_0x1659('0xa'));
	}
}
function vgca_sign_xml(_0x505d06, _0x74ab67, _0x1fc39a) {
	if (_0x1659('0x0') in window) {
		var _0x318dd3 = new WebSocket(_0x1659('0x15'));
		_0x318dd3[_0x1659('0x2')] = function() {
			_0x318dd3[_0x1659('0x3')](_0x74ab67);
		};
		_0x318dd3[_0x1659('0x5')] = function(_0x4b15a3) {
			if (_0x1fc39a) {
				_0x1fc39a(_0x505d06, _0x4b15a3[_0x1659('0xc')]);
			}
			_0x318dd3['close']();
		};
		_0x318dd3[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')]('Connection\x20is\x20closed...');
		};
	} else {
		if (_0x1fc39a) {
			_0x1fc39a(_0x505d06, _0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_get_certinfo(_0xb6742f) {
	if ('WebSocket' in window) {
		var _0x4a9914 = new WebSocket(_0x1659('0x16'));
		_0x4a9914['onopen'] = function() {
			_0x4a9914[_0x1659('0x3')](_0x1659('0x17'));
		};
		_0x4a9914['onmessage'] = function(_0x1ad7a6) {
			if (_0xb6742f) {
				_0xb6742f(_0x1ad7a6[_0x1659('0xc')]);
			}
			_0x4a9914['close']();
		};
		_0x4a9914[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0xb6742f) {
			_0xb6742f(sender, _0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_verify_xml(_0x502507, _0x28be51) {
	if (_0x1659('0x0') in window) {
		var _0x1c9e17 = new WebSocket(_0x1659('0x18'));
		_0x1c9e17[_0x1659('0x2')] = function() {
			_0x1c9e17['send'](_0x502507);
		};
		_0x1c9e17[_0x1659('0x5')] = function(_0x2ccba6) {
			if (_0x28be51) {
				_0x28be51(_0x2ccba6[_0x1659('0xc')]);
			}
			_0x1c9e17[_0x1659('0x6')]();
		};
		_0x1c9e17['onclose'] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x28be51) {
			_0x28be51(_0x1659('0x19'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_xml_wp12(_0x4e2a7c, _0x5def94) {
	if (_0x1659('0x0') in window) {
		var _0xa58235 = new WebSocket(_0x1659('0x1a'));
		_0xa58235[_0x1659('0x2')] = function() {
			_0xa58235[_0x1659('0x3')](_0x4e2a7c);
		};
		_0xa58235['onmessage'] = function(_0x7560fe) {
			if (_0x5def94) {
				_0x5def94(_0x7560fe['data']);
			}
			_0xa58235[_0x1659('0x6')]();
		};
		_0xa58235[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x5def94) {
			_0x5def94('{\x22Error\x22:\x20\x22WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!\x22,\x20\x22Status\x22:500}');
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_pdfwp(_0x3b269b, _0x34534d) {
	if (_0x1659('0x0') in window) {
		var _0x1c8ee3 = new WebSocket(_0x1659('0x1b'));
		_0x1c8ee3['onopen'] = function() {
			_0x1c8ee3[_0x1659('0x3')](_0x3b269b);
		};
		_0x1c8ee3['onmessage'] = function(_0x160f88) {
			if (_0x34534d) {
				_0x34534d(_0x160f88[_0x1659('0xc')]);
			}
			_0x1c8ee3['close']();
		};
		_0x1c8ee3[_0x1659('0x7')] = function() {
			console['log'](_0x1659('0x9'));
		};
	} else {
		if (_0x34534d) {
			_0x34534d(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_income(_0x1dafe8, _0x25b547) {
	if (_0x1659('0x0') in window) {
		var _0x14d5c6 = new WebSocket(_0x1659('0x1c'));
		_0x14d5c6[_0x1659('0x2')] = function() {
			_0x14d5c6['send'](_0x1dafe8);
		};
		_0x14d5c6['onmessage'] = function(_0x527e6e) {
			if (_0x25b547) {
				_0x25b547(_0x527e6e[_0x1659('0xc')]);
			}
			_0x14d5c6[_0x1659('0x6')]();
		};
		_0x14d5c6[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x25b547) {
			_0x25b547(_0x1659('0xd'));
		}
		console[_0x1659('0x8')]
				('WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!');
	}
}
function vgca_auth(_0x5eb793, _0x4d7c77, _0x3dc5ca) {
	if (_0x1659('0x0') in window) {
		var _0x89a16a = new WebSocket(_0x1659('0x1d'));
		_0x89a16a[_0x1659('0x2')] = function() {
			_0x89a16a[_0x1659('0x3')](_0x4d7c77);
		};
		_0x89a16a[_0x1659('0x5')] = function(_0x149a8e) {
			if (_0x3dc5ca) {
				_0x3dc5ca(_0x5eb793, _0x149a8e[_0x1659('0xc')]);
			}
			_0x89a16a[_0x1659('0x6')]();
		};
		_0x89a16a[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x3dc5ca) {
			_0x3dc5ca(_0x5eb793, _0x1659('0xd'));
		}
		console[_0x1659('0x8')]
				('WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!');
	}
}
function vgca_sign_approved(_0x465e97, _0x221fba) {
	if (_0x1659('0x0') in window) {
		var _0xcfc9c7 = new WebSocket('wss://127.0.0.1:8987/SignApproved');
		_0xcfc9c7[_0x1659('0x2')] = function() {
			_0xcfc9c7[_0x1659('0x3')](_0x465e97);
		};
		_0xcfc9c7['onmessage'] = function(_0x27b3d9) {
			if (_0x221fba) {
				_0x221fba(_0x27b3d9[_0x1659('0xc')]);
			}
			_0xcfc9c7[_0x1659('0x6')]();
		};
		_0xcfc9c7[_0x1659('0x7')] = function() {
			console[_0x1659('0x8')]('Connection\x20is\x20closed...');
		};
	} else {
		if (_0x221fba) {
			_0x221fba(_0x1659('0xd'));
		}
		console[_0x1659('0x8')](_0x1659('0xa'));
	}
}
function vgca_sign_issued(_0x3ad696, _0x3dc699) {
	if (_0x1659('0x0') in window) {
		var _0x213b0b = new WebSocket(_0x1659('0x1e'));
		_0x213b0b[_0x1659('0x2')] = function() {
			_0x213b0b['send'](_0x3ad696);
		};
		_0x213b0b[_0x1659('0x5')] = function(_0x5570d5) {
			if (_0x3dc699) {
				_0x3dc699(_0x5570d5[_0x1659('0xc')]);
			}
			_0x213b0b['close']();
		};
		_0x213b0b['onclose'] = function() {
			console[_0x1659('0x8')](_0x1659('0x9'));
		};
	} else {
		if (_0x3dc699) {
			_0x3dc699(_0x1659('0xd'));
		}
		console[_0x1659('0x8')]
				('WebSocket\x20NOT\x20supported\x20by\x20your\x20Browser!');
	}
}