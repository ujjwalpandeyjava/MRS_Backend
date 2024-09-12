import packageJson from '../../package.json'

function urlSetup(toWhere) {
	let link = `/${packageJson.homepage}`;
	if (toWhere)
		link += toWhere;
	return link;
}

export { urlSetup };