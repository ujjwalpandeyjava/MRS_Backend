import cssModule from './ErrorPage.module.css'
// import pageNotFoundImg from './components/notFound/404 Error with a cute animal-bro.svg'
import pageNotFoundImg from './images/Computer troubleshooting-amico.svg'

function ErrorPage() {
	return (
		<div className={cssModule.notFound}>
			<h1>Error while getting data</h1>
			<img loading='lazy' className={cssModule.cat} alt="Cat hanging on 404" src={pageNotFoundImg} />
		</div>
	)
}

export default ErrorPage